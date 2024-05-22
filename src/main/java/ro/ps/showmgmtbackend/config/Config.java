package ro.ps.showmgmtbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.ps.showmgmtbackend.mapper.CommentMapper;
import ro.ps.showmgmtbackend.mapper.OrderMapper;
import ro.ps.showmgmtbackend.mapper.ShowMapper;
import ro.ps.showmgmtbackend.mapper.UserMapper;
import ro.ps.showmgmtbackend.repository.CommentRepository;
import ro.ps.showmgmtbackend.repository.OrderRepository;
import ro.ps.showmgmtbackend.repository.ShowRepository;
import ro.ps.showmgmtbackend.repository.UserRepository;
import ro.ps.showmgmtbackend.service.comment.CommentService;
import ro.ps.showmgmtbackend.service.comment.CommentServiceBean;
import ro.ps.showmgmtbackend.service.order.OrderService;
import ro.ps.showmgmtbackend.service.order.OrderServiceBean;
import ro.ps.showmgmtbackend.service.show.ShowService;
import ro.ps.showmgmtbackend.service.show.ShowServiceBean;
import ro.ps.showmgmtbackend.service.user.UserService;
import ro.ps.showmgmtbackend.service.user.UserServiceBean;

@Configuration
public class Config {
    @Bean
    public ShowService showServiceBean(
            ShowRepository showRepository,
            ShowMapper showMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new ShowServiceBean(showRepository, showMapper, applicationName);
    }

    @Bean
    public UserService userServiceBean(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new UserServiceBean(userRepository, userMapper, applicationName, passwordEncoder);
    }

    @Bean
    public CommentService commentServiceBean(
            CommentRepository commentRepository,
            CommentMapper commentMapper,
            UserMapper userMapper,
            ShowMapper showMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new CommentServiceBean(commentRepository, commentMapper, userMapper, showMapper, applicationName);
    }

    @Bean
    public OrderService orderServiceBean(
            ShowService showService,
            OrderRepository orderRepository,
            OrderMapper orderMapper,
            UserMapper userMapper,
            ShowMapper showMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new OrderServiceBean(orderRepository, orderMapper, userMapper, showMapper, showService, applicationName);
    }
}
