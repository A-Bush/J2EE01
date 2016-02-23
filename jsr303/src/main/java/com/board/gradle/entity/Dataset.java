package com.board.gradle.entity;


import com.board.gradle.valiadator.CheckDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataset {
    @CheckDate
    private String acceptanceDate;
    @NotBlank(message = "Deposit date is required")
    @CheckDate(dateFormat = "YYYY-MM-DD")
    private String depositDate;
    @CheckDate(dateFormat = "YYYY")
    private String publicationDate;
    @CheckDate(dateFormat = {"YYYY","YYYY-MM"})
    private String collectionDate;


}
