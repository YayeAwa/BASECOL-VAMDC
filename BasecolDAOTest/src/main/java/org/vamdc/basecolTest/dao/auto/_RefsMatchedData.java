package org.vamdc.basecolTest.dao.auto;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.vamdc.BasecolTest.dao.ForeignValuesSets;
import org.vamdc.BasecolTest.dao.MatchedEnergyTables;
import org.vamdc.BasecolTest.dao.SpectroDatabases;

/**
 * Class _RefsMatchedData was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _RefsMatchedData extends CayenneDataObject {

    public static final String CREATION_DATE_PROPERTY = "creationDate";
    public static final String DATE_OF_ENTRY_PROPERTY = "dateOfEntry";
    public static final String FILE_NAME_PROPERTY = "fileName";
    public static final String ID_CHEMICAL_ELEMENT_SPECTRO_PROPERTY = "idChemicalElementSpectro";
    public static final String ID_REF_PROPERTY = "idRef";
    public static final String INFOS_URL_PROPERTY = "infosUrl";
    public static final String VERSION_PROPERTY = "version";
    public static final String FOREIGNVALUESSETSS_PROPERTY = "foreignvaluessetss";
    public static final String MATCHEDENERGYTABLESES_PROPERTY = "matchedenergytableses";
    public static final String TO_SPECTRO_DATABASES_PROPERTY = "toSpectroDatabases";

    public static final String ID_REF_PK_COLUMN = "idRef";

    public void setCreationDate(Date creationDate) {
        writeProperty(CREATION_DATE_PROPERTY, creationDate);
    }
    public Date getCreationDate() {
        return (Date)readProperty(CREATION_DATE_PROPERTY);
    }

    public void setDateOfEntry(String dateOfEntry) {
        writeProperty(DATE_OF_ENTRY_PROPERTY, dateOfEntry);
    }
    public String getDateOfEntry() {
        return (String)readProperty(DATE_OF_ENTRY_PROPERTY);
    }

    public void setFileName(String fileName) {
        writeProperty(FILE_NAME_PROPERTY, fileName);
    }
    public String getFileName() {
        return (String)readProperty(FILE_NAME_PROPERTY);
    }

    public void setIdChemicalElementSpectro(Long idChemicalElementSpectro) {
        writeProperty(ID_CHEMICAL_ELEMENT_SPECTRO_PROPERTY, idChemicalElementSpectro);
    }
    public Long getIdChemicalElementSpectro() {
        return (Long)readProperty(ID_CHEMICAL_ELEMENT_SPECTRO_PROPERTY);
    }

    public void setIdRef(Long idRef) {
        writeProperty(ID_REF_PROPERTY, idRef);
    }
    public Long getIdRef() {
        return (Long)readProperty(ID_REF_PROPERTY);
    }

    public void setInfosUrl(String infosUrl) {
        writeProperty(INFOS_URL_PROPERTY, infosUrl);
    }
    public String getInfosUrl() {
        return (String)readProperty(INFOS_URL_PROPERTY);
    }

    public void setVersion(String version) {
        writeProperty(VERSION_PROPERTY, version);
    }
    public String getVersion() {
        return (String)readProperty(VERSION_PROPERTY);
    }

    public void addToForeignvaluessetss(ForeignValuesSets obj) {
        addToManyTarget(FOREIGNVALUESSETSS_PROPERTY, obj, true);
    }
    public void removeFromForeignvaluessetss(ForeignValuesSets obj) {
        removeToManyTarget(FOREIGNVALUESSETSS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<ForeignValuesSets> getForeignvaluessetss() {
        return (List<ForeignValuesSets>)readProperty(FOREIGNVALUESSETSS_PROPERTY);
    }


    public void addToMatchedenergytableses(MatchedEnergyTables obj) {
        addToManyTarget(MATCHEDENERGYTABLESES_PROPERTY, obj, true);
    }
    public void removeFromMatchedenergytableses(MatchedEnergyTables obj) {
        removeToManyTarget(MATCHEDENERGYTABLESES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<MatchedEnergyTables> getMatchedenergytableses() {
        return (List<MatchedEnergyTables>)readProperty(MATCHEDENERGYTABLESES_PROPERTY);
    }


    public void setToSpectroDatabases(SpectroDatabases toSpectroDatabases) {
        setToOneTarget(TO_SPECTRO_DATABASES_PROPERTY, toSpectroDatabases, true);
    }

    public SpectroDatabases getToSpectroDatabases() {
        return (SpectroDatabases)readProperty(TO_SPECTRO_DATABASES_PROPERTY);
    }


}
