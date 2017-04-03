package giraffe.services;

import giraffe.domain.GiraffeAuthority;
import giraffe.domain.User;
import giraffe.repository.AuthorityRepository;
import giraffe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Guschcyna Olga
 * @version 1.0.0
 */
@Service
public class SocialUserService {

    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    @Autowired
    public SocialUserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Transactional
    public User createSocialUser(String socialId, String email, User.SocialProvider socialProvider) {
        User socialUser = new User().setLogin(email)
                .setSocialId(socialId)
                .setSocialProvider(socialProvider)
                .setUserType(User.UserType.SOCIAL)
                .addAuthority(authorityRepository.findByRole(GiraffeAuthority.Role.USER));

        return userRepository.save(socialUser);
    }

}
