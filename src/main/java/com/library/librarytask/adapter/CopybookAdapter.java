package com.library.librarytask.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.library.librarytask.domain.dto.CopyBookDto;
import com.library.librarytask.repository.CopyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class CopybookAdapter extends TypeAdapter<CopyBookDto> {

    @Autowired
    private CopyBookRepository copyBookRepository;


    @Override
    public void write(JsonWriter out, CopyBookDto value) throws IOException {
        if (value == null){
            out.nullValue();
        } else {
            out.value(value.getId());
        }
    }

    @Override
    public CopyBookDto read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        } else {
            return null;
        }
    }
}
