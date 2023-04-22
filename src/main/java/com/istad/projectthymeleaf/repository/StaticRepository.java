package com.istad.projectthymeleaf.repository;


import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.model.Categories;
import com.istad.projectthymeleaf.model.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



//yg make data Article oy mean sin chea array list
@Repository
@Getter //yg can yk data tam getter nis ban
public class StaticRepository {
    //DI Faker to StaticRepository
    private Faker faker;
    @Autowired  //DI yk Bean

    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    private List<Article> articles;
    private List<Categories> cat;
    private List<User> userList;
    @PostConstruct
    void initArticle(){
        cat = new ArrayList<>();
        cat.add(new Categories("Gamming"));
        cat.add(new Categories("Stories"));
        cat.add(new Categories("Student"));
        cat.add(new Categories("Programming"));
        cat.add(new Categories("Science"));
        cat.add(new Categories("Other"));
        articles= new ArrayList<>(){{
            add(new Article(userList,"https://i.pinimg.com/564x/c4/9d/51/c49d51ff81e8d1a3e2c72796c6d6a359.jpg",UUID.randomUUID(),"hese breakthroughs are propelling us towards a new era of innovation and discovery.",cat));
            add(new Article(userList,"https://i.pinimg.com/564x/c4/9d/51/c49d51ff81e8d1a3e2c72796c6d6a359.jpg" ,UUID.randomUUID(),"Get ready to embark on a journey of technological marvels",cat));
            add(new Article(userList,"https://i.pinimg.com/564x/63/a4/a1/63a4a1d6ad3d616e18a1ec9690fe4a35.jpg" ,UUID.randomUUID(),"Cutting-Edge Breakthroughs in Science and TechnologyT",cat));
            add(new Article(userList,"https://i.pinimg.com/564x/ab/a1/8c/aba18ca1848b036a0dcfc871d46d3e6a.jpg",UUID.randomUUID(),"Trailblazing Advances in Science, Technology, and Beyond",cat));
        }};
    }
    @PostConstruct
    void initUser(){
        userList = new ArrayList<>(){{
            for (int i = 0; i < 5; i++) {
                add(new User(faker.book().author(),faker.avatar().image(),faker.gender().toString(),faker.address().city()));
            }
        }};
    }
}
