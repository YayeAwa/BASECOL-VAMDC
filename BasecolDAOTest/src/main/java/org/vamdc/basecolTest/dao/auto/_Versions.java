package org.vamdc.basecolTest.dao.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _Versions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Versions extends CayenneDataObject {

    public static final String COMMENT_PROPERTY = "comment";
    public static final String CREATION_DATE_PROPERTY = "creationDate";
    public static final String ID_VERSION_PROPERTY = "idVersion";
    public static final String ID_VERSIONED_ELEMENT_PROPERTY = "idVersionedElement";
    public static final String VERSION_NUMBER_PROPERTY = "versionNumber";
    public static final String VERSION_TYPE_PROPERTY = "versionType";

    public static final String ID_VERSION_PK_COLUMN = "idVersion";

    public void setComment(String comment) {
        writeProperty(COMMENT_PROPERTY, comment);
    }
    public String getComment() {
        return (String)readProperty(COMMENT_PROPERTY);
    }

    public void setCreationDate(Date creationDate) {
        writeProperty(CREATION_DATE_PROPERTY, creationDate);
    }
    public Date getCreationDate() {
        return (Date)readProperty(CREATION_DATE_PROPERTY);
    }

    public void setIdVersion(Long idVersion) {
        writeProperty(ID_VERSION_PROPERTY, idVersion);
    }
    public Long getIdVersion() {
        return (Long)readProperty(ID_VERSION_PROPERTY);
    }

    public void setIdVersionedElement(Long idVersionedElement) {
        writeProperty(ID_VERSIONED_ELEMENT_PROPERTY, idVersionedElement);
    }
    public Long getIdVersionedElement() {
        return (Long)readProperty(ID_VERSIONED_ELEMENT_PROPERTY);
    }

    public void setVersionNumber(Short versionNumber) {
        writeProperty(VERSION_NUMBER_PROPERTY, versionNumber);
    }
    public Short getVersionNumber() {
        return (Short)readProperty(VERSION_NUMBER_PROPERTY);
    }

    public void setVersionType(String versionType) {
        writeProperty(VERSION_TYPE_PROPERTY, versionType);
    }
    public String getVersionType() {
        return (String)readProperty(VERSION_TYPE_PROPERTY);
    }

}
