package jp.kakakakakku.certification.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "certifications")
public class CertificationEntity {
    // TODO: 提供停止フラグ
    // TODO: 定期開催と任意受験

    public CertificationEntity() {
    }

    public CertificationEntity(
            String name,
            String organizationName,
            String primaryCategory,
            Integer price,
            String url,
            String keywords) {
        this.name = name;
        this.organizationName = organizationName;
        this.primaryCategory = primaryCategory;
        this.price = price;
        this.url = url;
        this.keywords = keywords;
    }

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String organizationName;

    @DatabaseField
    private String primaryCategory;

    @DatabaseField
    private Integer price;

    @DatabaseField
    private String url;

    @DatabaseField
    private String keywords;

    public void setId(Integer id) { this.id = id; }
    public Integer getId() { return this.id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }
    public String getOrganizationName() { return this.organizationName; }

    public void setPrimaryCategory(String primaryCategory) { this.primaryCategory = primaryCategory; }
    public String getPrimaryCategory() { return this.primaryCategory; }

    public void setPrice(Integer price) { this.price = price; }
    public Integer getPrice() { return this.price; }
    public String getPriceWithYen() { return this.price.toString() + "円"; }

    public void setUrl(String url) { this.url = url; }
    public String getUrl() { return this.url; }

    public void setKeywords(String keywords) { this.keywords = keywords; }
    public String getKeywords() { return this.keywords; }

}
