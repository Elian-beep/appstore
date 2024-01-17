package com.kihan.appstore.entity;

import com.kihan.appstore.dto.AppDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "apps")
public class App {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate published;
    @NotNull
    @Min(value = 200, message = "O tamanho deve ser superior a 200kb")
    private Double size;

    public void setPublished(String publishedString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.published = LocalDate.parse(publishedString, formatter);
    }

    public String getPublished() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return published.format(formatter);
    }

    public App(AppDTO appDTO){
        setName(appDTO.name());
        setSize(appDTO.size());
        setPublished(appDTO.published());
    }
}