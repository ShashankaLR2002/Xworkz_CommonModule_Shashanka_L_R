package com.xworkz.cmodule.constants;

import lombok.Getter;

@Getter
public enum ImagePath {
    IMAGE_PATH("D:\\Commons-File-Upload\\");

    private String path;

    ImagePath(String path) {
        this.path = path;
    }

}
