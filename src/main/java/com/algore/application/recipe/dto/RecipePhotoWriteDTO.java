package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

public class RecipePhotoWriteDTO {

    private String recipeFileName; // 파일명
    private String recipePhotoPath; // 저장경로


    public RecipePhotoWriteDTO() {
    }

    public RecipePhotoWriteDTO(String recipeFileName, String recipePhotoPath) {
        this.recipeFileName = recipeFileName;
        this.recipePhotoPath = recipePhotoPath;
    }

    public String getRecipeFileName() {
        return recipeFileName;
    }

    public void setRecipeFileName(String recipeFileName) {
        this.recipeFileName = recipeFileName;
    }

    public String getRecipePhotoPath() {
        return recipePhotoPath;
    }

    public void setRecipePhotoPath(String recipePhotoPath) {
        this.recipePhotoPath = recipePhotoPath;
    }

    @Override
    public String toString() {
        return "RecipePhotoWriteDTO{" +
                "recipeFileName='" + recipeFileName + '\'' +
                ", recipePhotoPath='" + recipePhotoPath + '\'' +
                '}';
    }
}
