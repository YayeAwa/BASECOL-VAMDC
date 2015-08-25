package org.vamdc.basecolTest.dao.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.FitEquations;
import org.vamdc.BasecolTest.dao.FitValues;

/**
 * Class _Fits was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Fits extends CayenneDataObject {

    public static final String ID_FIT_PROPERTY = "idFit";
    public static final String PRECIS_PROPERTY = "precis";
    public static final String TEXT_PROPERTY = "text";
    public static final String TITLE_PROPERTY = "title";
    public static final String FITVALUESES_PROPERTY = "fitvalueses";
    public static final String TO_COLLISIONS_PROPERTY = "toCollisions";
    public static final String TO_FIT_EQUATIONS_PROPERTY = "toFitEquations";

    public static final String ID_FIT_PK_COLUMN = "idFit";

    public void setIdFit(Long idFit) {
        writeProperty(ID_FIT_PROPERTY, idFit);
    }
    public Long getIdFit() {
        return (Long)readProperty(ID_FIT_PROPERTY);
    }

    public void setPrecis(String precis) {
        writeProperty(PRECIS_PROPERTY, precis);
    }
    public String getPrecis() {
        return (String)readProperty(PRECIS_PROPERTY);
    }

    public void setText(String text) {
        writeProperty(TEXT_PROPERTY, text);
    }
    public String getText() {
        return (String)readProperty(TEXT_PROPERTY);
    }

    public void setTitle(String title) {
        writeProperty(TITLE_PROPERTY, title);
    }
    public String getTitle() {
        return (String)readProperty(TITLE_PROPERTY);
    }

    public void addToFitvalueses(FitValues obj) {
        addToManyTarget(FITVALUESES_PROPERTY, obj, true);
    }
    public void removeFromFitvalueses(FitValues obj) {
        removeToManyTarget(FITVALUESES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<FitValues> getFitvalueses() {
        return (List<FitValues>)readProperty(FITVALUESES_PROPERTY);
    }


    public void setToCollisions(Collisions toCollisions) {
        setToOneTarget(TO_COLLISIONS_PROPERTY, toCollisions, true);
    }

    public Collisions getToCollisions() {
        return (Collisions)readProperty(TO_COLLISIONS_PROPERTY);
    }


    public void setToFitEquations(FitEquations toFitEquations) {
        setToOneTarget(TO_FIT_EQUATIONS_PROPERTY, toFitEquations, true);
    }

    public FitEquations getToFitEquations() {
        return (FitEquations)readProperty(TO_FIT_EQUATIONS_PROPERTY);
    }


}