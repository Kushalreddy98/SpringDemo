package com.bookapp.util;

import com.bookapp.model.Book;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class BookDetails {
    public  List<Book> showBooks(){
        return Arrays.asList(
                new Book("Java","John","tech",101,2000),
                new Book("Liquor","Paul John","Drinks",101,2000),
                new Book("sql","robin","tech",102,3000),
                new Book("My Life","Kushal","Auto Bio",103,6000),
                new Book("Festivals","Manju","Festival",104,2000),
                new Book("Holiday Dairy","Basava","Comedy",105,1000)
        );
    }
}
