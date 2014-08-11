package jp.kakakakakku.certification.adapter;

import jp.kakakakakku.certification.db.entity.CertificationEntity;

public class SectionRowData {

    public SectionRowData(Integer id, String label, String value) {
        this.id = id;
        this.label = label;
        this.value = value;
    }

    public Integer id;
    public String label;
    public String value;

    public static SectionRowData getDafaultRow (CertificationEntity c) {
        return new SectionRowData(c.getId(), c.getName(), c.getKeywords());
    }
}
