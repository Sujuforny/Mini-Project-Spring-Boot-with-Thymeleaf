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
    private User user;
    private List<User> userList;
    private List<Categories> categoriesList;
    @PostConstruct
    void initArticle(){
        user = new User("fufy","@{/resources/img/profile/1.jpg}","male","Select fields components are used for collecting user provided information from a list of options.","fufy@gmail.com","RUPP Auditorium, មហាវិថី សហពន្ធ័រុស្ស៊ី (១១០), ភ្នំពេញ","@{/resources/img/profile/1.jpg}");

        //  UserList

        userList = new ArrayList<>();
                              //userName profileImg                    gender description                                                                                         email             ;address                                     ;cover;
        userList.add(new User("fufy","1.jpg","male","Select fields components are used for collecting user provided information from a list of options.","fufy@gmail.com","RUPP Auditorium, មហាវិថី សហពន្ធ័រុស្ស៊ី (១១០), ភ្នំពេញ","@{/resources/img/profile/1.jpg}"));
        userList.add(new User("lufy","2.jpg","male","Love is a complex and multifaceted emotion that humans experience towards others or even towards oneself","fufy@gmail.com","RUPP Auditorium, មហាវិថី សហពន្ធ័រុស្ស៊ី (១១០), ភ្នំពេញ","@{/resources/img/profile/1.jpg}"));
        userList.add(new User("kiki","3.jpg","male"," It is generally characterized by affection, care, compassion, attachment, and deep emotional connection.","fufy@gmail.com","RUPP Auditorium, មហាវិថី សហពន្ធ័រុស្ស៊ី (១១០), ភ្នំពេញ","@{/resources/img/profile/1.jpg}"));
        userList.add(new User("jonhson","4.jpg","male","Love can manifest in various forms, such as romantic love, familial love, platonic love, and self-love","fufy@gmail.com","RUPP Auditorium, មហាវិថី សហពន្ធ័រុស្ស៊ី (១១០), ភ្នំពេញ","@{/resources/img/profile/1.jpg}"));
        userList.add(new User("lala128","5.jpg","male","Romantic love typically involves feelings of passion, intimacy, and commitment towards a romantic partner","fufy@gmail.com","RUPP Auditorium, មហាវិថី សហពន្ធ័រុស្ស៊ី (១១០), ភ្នំពេញ","@{/resources/img/profile/1.jpg}"));

        categoriesList = new ArrayList<>();
        categoriesList.add(new Categories("Gamming"));
        categoriesList.add(new Categories("Stories"));
        categoriesList.add(new Categories("Student"));
        categoriesList.add(new Categories("Programming"));
        categoriesList.add(new Categories("Science"));
        categoriesList.add(new Categories("Other"));
        articles= new ArrayList<>(){{
            add(new Article(user,"1.jpg",UUID.randomUUID(),"hese breakthroughs are propelling us towards a new era of innovation and discovery.",categoriesList));
            add(new Article(user,"2.jpg",UUID.randomUUID(),"Get ready to embark on a journey of technological marvels",categoriesList));
            add(new Article(user,"3.jpg",UUID.randomUUID(),"Cutting-Edge Breakthroughs in Science and TechnologyT",categoriesList));
        }};
    }
//    @PostConstruct
//    void initUser(){
//        userList = new ArrayList<>(){{
//            for (int i = 0; i < 5; i++) {
//                add(new User(faker.book().author(),faker.avatar().image(),faker.gender().toString(),faker.address().city()));
//            }
//        }};
//    }
}
