package com.ulearn.dgsFramework.model;

import lombok.*;
import net.datafaker.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
    private String title;
    private int releaseYear;
    private Review reviews;
}
