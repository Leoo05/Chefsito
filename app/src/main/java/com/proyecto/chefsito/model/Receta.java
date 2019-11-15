package com.proyecto.chefsito.model;

public class Receta {
    private String title;
    private String type;
    private String tag;
    private String description;
    private String instructions;
    private String video;

    public Receta(String title, String type, String tag, String description, String instructions, String video){
        setTitle(title);
        setType(type);
        setTag(tag);
        setDescription(description);
        setInstructions(instructions);
        setVideo(video);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }


}
