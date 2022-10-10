package com.library.librarytask.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.librarytask.domain.Rents;
import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CopyBookDto {

    @JsonProperty("ID")
    private long id;
    @JsonProperty("Title")
    private Title title;
    @JsonProperty("Status")
    private Status status;

    public CopyBookDto(Title title, Status status) {
        this.title = title;
        this.status = status;
    }
}
