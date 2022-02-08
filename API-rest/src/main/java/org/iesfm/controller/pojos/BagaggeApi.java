package org.iesfm.controller.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BagaggeApi {

    private Integer code;
    private String description;

    @JsonCreator
    public BagaggeApi(@JsonProperty("code") Integer code,
                      @JsonProperty("description") String description) {
        this.code = code;
        this.description = description;
    }

    public BagaggeApi(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagaggeApi bagagge = (BagaggeApi) o;
        return Objects.equals(code, bagagge.code) && Objects.equals(description, bagagge.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bagagge{");
        sb.append("code=").append(code);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
