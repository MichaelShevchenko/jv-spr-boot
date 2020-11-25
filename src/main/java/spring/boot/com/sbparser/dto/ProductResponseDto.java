package spring.boot.com.sbparser.dto;

public class ProductResponseDto {
    private String externalId;

    public ProductResponseDto() {
    }

    public ProductResponseDto(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
