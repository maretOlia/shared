package giraffe.services;


import giraffe.domain.GiraffeEntity;
import giraffe.domain.GiraffeException;
import giraffe.domain.GiraffeUserDetails;
import giraffe.domain.User;
import giraffe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Guschcyna Olga
 * @version 1.0.0
 */
@Service
public class GiraffeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SocialUserService socialUserService;


    @Autowired
    public GiraffeUserDetailsService(UserRepository userRepository, SocialUserService socialUserService) {

        this.userRepository = userRepository;
        this.socialUserService = socialUserService;
    }

    @Override
    public GiraffeUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User account = userRepository.findByLoginAndStatus(username,  GiraffeEntity.Status.ACTIVE);

        if (account == null)
            throw new UsernameNotFoundException("Account with login: " + username + " not found");

        return new GiraffeUserDetails(account.getLogin(), account.getPasswordHash(), account.getAuthorities(), account.getUuid(), false, false, false, true);
    }


    public GiraffeUserDetails loadOrCreateSocialUser(String socialId, String email, User.SocialProvider socialProvider) throws GiraffeException.UnableToValidateSocialUserInformation {

        if (socialId == null) throw new GiraffeException.UnableToValidateSocialUserInformation();

        User account = userRepository.findBySocialIdAndSocialProviderAndStatus(socialId, socialProvider, GiraffeEntity.Status.ACTIVE);

        if (account == null) {
            account = socialUserService.createSocialUser(socialId, email, socialProvider);
        }

        return new GiraffeUserDetails(Optional.ofNullable(account.getLogin()).orElse(account.getSocialId()), null, account.getAuthorities(), account.getUuid(), false, false, false, true);
    }

}
