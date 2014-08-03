package jp.kakakakakku.certification.adapter;

import jp.kakakakakku.certification.db.entity.CertificationEntity;

public class SectionRowData {

    public SectionRowData(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String label;
    public String value;

    public static SectionRowData getDafaultRow (CertificationEntity c) {
        return new SectionRowData(c.getName(), c.getKeywords());
    }
}
