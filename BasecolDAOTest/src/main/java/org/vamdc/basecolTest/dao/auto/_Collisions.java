package org.vamdc.basecolTest.dao.auto;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.vamdc.BasecolTest.dao.CollisionsProcessus;
import org.vamdc.BasecolTest.dao.CollisionsScientists;
import org.vamdc.BasecolTest.dao.Contributors;
import org.vamdc.BasecolTest.dao.EnergyTables;
import org.vamdc.BasecolTest.dao.Fits;
import org.vamdc.BasecolTest.dao.ForeignValuesSetsCollisions;
import org.vamdc.BasecolTest.dao.LevelGroups;
import org.vamdc.BasecolTest.dao.MatchedEnergyTablesCollisions;
import org.vamdc.BasecolTest.dao.RateCoefficients;
import org.vamdc.BasecolTest.dao.RefsGroups;
import org.vamdc.BasecolTest.dao.StatusAvailables;
import org.vamdc.BasecolTest.dao.Units;

/**
 * Class _Collisions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Collisions extends CayenneDataObject {

    public static final String BASIS_SET_PROPERTY = "basisSet";
    public static final String COMMENT_PROPERTY = "comment";
    public static final String CREATION_DATE_PROPERTY = "creationDate";
    public static final String ID_COLLISION_PROPERTY = "idCollision";
    public static final String IS_VISIBLE_PROPERTY = "isVisible";
    public static final String METHOD_COMMENT_PROPERTY = "methodComment";
    public static final String MODIFICATION_DATE_PROPERTY = "modificationDate";
    public static final String PES_COMMENT_PROPERTY = "pesComment";
    public static final String RANGE_OF_ENERGY_PROPERTY = "rangeOfEnergy";
    public static final String RECOMMENDED_PROPERTY = "recommended";
    public static final String REDUCED_MASS_VALUE_PROPERTY = "reducedMassValue";
    public static final String TITLE_PROPERTY = "title";
    public static final String YEAR_PROPERTY = "year";
    public static final String COLLISIONS_PROCESSUSES_PROPERTY = "collisionsProcessuses";
    public static final String COLLISIONS_SCIENTISTSS_PROPERTY = "collisionsScientistss";
    public static final String FITSS_PROPERTY = "fitss";
    public static final String FOREIGNVALUESSETS_COLLISIONSS_PROPERTY = "foreignvaluessetsCollisionss";
    public static final String LEVELGROUPSS_PROPERTY = "levelgroupss";
    public static final String MATCHEDENERGYTABLES_COLLISIONSS_PROPERTY = "matchedenergytablesCollisionss";
    public static final String RATECOEFFICIENTSS_PROPERTY = "ratecoefficientss";
    public static final String TO_COLLISIONS_PROPERTY = "toCollisions";
    public static final String TO_CONTRIBUTORS_PROPERTY = "toContributors";
    public static final String TO_ENERGY_COLLIDER_PROPERTY = "toEnergyCollider";
    public static final String TO_ENERGY_TARGET_PROPERTY = "toEnergyTarget";
    public static final String TO_REFS_GROUPS_PROPERTY = "toRefsGroups";
    public static final String TO_REFS_METHOD_PROPERTY = "toRefsMethod";
    public static final String TO_REFS_PES_PROPERTY = "toRefsPES";
    public static final String TO_REFS_REDU_MASS_PROPERTY = "toRefsReduMass";
    public static final String TO_UNITS_PROPERTY = "toUnits";

    public static final String ID_COLLISION_PK_COLUMN = "idCollision";

    public void setBasisSet(String basisSet) {
        writeProperty(BASIS_SET_PROPERTY, basisSet);
    }
    public String getBasisSet() {
        return (String)readProperty(BASIS_SET_PROPERTY);
    }

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

    public void setIdCollision(long idCollision) {
        writeProperty(ID_COLLISION_PROPERTY, idCollision);
    }
    public long getIdCollision() {
        Object value = readProperty(ID_COLLISION_PROPERTY);
        return (value != null) ? (Long) value : 0;
    }

    public void setIsVisible(Short isVisible) {
        writeProperty(IS_VISIBLE_PROPERTY, isVisible);
    }
    public Short getIsVisible() {
        return (Short)readProperty(IS_VISIBLE_PROPERTY);
    }

    public void setMethodComment(String methodComment) {
        writeProperty(METHOD_COMMENT_PROPERTY, methodComment);
    }
    public String getMethodComment() {
        return (String)readProperty(METHOD_COMMENT_PROPERTY);
    }

    public void setModificationDate(Date modificationDate) {
        writeProperty(MODIFICATION_DATE_PROPERTY, modificationDate);
    }
    public Date getModificationDate() {
        return (Date)readProperty(MODIFICATION_DATE_PROPERTY);
    }

    public void setPesComment(String pesComment) {
        writeProperty(PES_COMMENT_PROPERTY, pesComment);
    }
    public String getPesComment() {
        return (String)readProperty(PES_COMMENT_PROPERTY);
    }

    public void setRangeOfEnergy(String rangeOfEnergy) {
        writeProperty(RANGE_OF_ENERGY_PROPERTY, rangeOfEnergy);
    }
    public String getRangeOfEnergy() {
        return (String)readProperty(RANGE_OF_ENERGY_PROPERTY);
    }

    public void setRecommended(String recommended) {
        writeProperty(RECOMMENDED_PROPERTY, recommended);
    }
    public String getRecommended() {
        return (String)readProperty(RECOMMENDED_PROPERTY);
    }

    public void setReducedMassValue(Double reducedMassValue) {
        writeProperty(REDUCED_MASS_VALUE_PROPERTY, reducedMassValue);
    }
    public Double getReducedMassValue() {
        return (Double)readProperty(REDUCED_MASS_VALUE_PROPERTY);
    }

    public void setTitle(String title) {
        writeProperty(TITLE_PROPERTY, title);
    }
    public String getTitle() {
        return (String)readProperty(TITLE_PROPERTY);
    }

    public void setYear(Integer year) {
        writeProperty(YEAR_PROPERTY, year);
    }
    public Integer getYear() {
        return (Integer)readProperty(YEAR_PROPERTY);
    }

    public void addToCollisionsProcessuses(CollisionsProcessus obj) {
        addToManyTarget(COLLISIONS_PROCESSUSES_PROPERTY, obj, true);
    }
    public void removeFromCollisionsProcessuses(CollisionsProcessus obj) {
        removeToManyTarget(COLLISIONS_PROCESSUSES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<CollisionsProcessus> getCollisionsProcessuses() {
        return (List<CollisionsProcessus>)readProperty(COLLISIONS_PROCESSUSES_PROPERTY);
    }


    public void addToCollisionsScientistss(CollisionsScientists obj) {
        addToManyTarget(COLLISIONS_SCIENTISTSS_PROPERTY, obj, true);
    }
    public void removeFromCollisionsScientistss(CollisionsScientists obj) {
        removeToManyTarget(COLLISIONS_SCIENTISTSS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<CollisionsScientists> getCollisionsScientistss() {
        return (List<CollisionsScientists>)readProperty(COLLISIONS_SCIENTISTSS_PROPERTY);
    }


    public void addToFitss(Fits obj) {
        addToManyTarget(FITSS_PROPERTY, obj, true);
    }
    public void removeFromFitss(Fits obj) {
        removeToManyTarget(FITSS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Fits> getFitss() {
        return (List<Fits>)readProperty(FITSS_PROPERTY);
    }


    public void addToForeignvaluessetsCollisionss(ForeignValuesSetsCollisions obj) {
        addToManyTarget(FOREIGNVALUESSETS_COLLISIONSS_PROPERTY, obj, true);
    }
    public void removeFromForeignvaluessetsCollisionss(ForeignValuesSetsCollisions obj) {
        removeToManyTarget(FOREIGNVALUESSETS_COLLISIONSS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<ForeignValuesSetsCollisions> getForeignvaluessetsCollisionss() {
        return (List<ForeignValuesSetsCollisions>)readProperty(FOREIGNVALUESSETS_COLLISIONSS_PROPERTY);
    }


    public void addToLevelgroupss(LevelGroups obj) {
        addToManyTarget(LEVELGROUPSS_PROPERTY, obj, true);
    }
    public void removeFromLevelgroupss(LevelGroups obj) {
        removeToManyTarget(LEVELGROUPSS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<LevelGroups> getLevelgroupss() {
        return (List<LevelGroups>)readProperty(LEVELGROUPSS_PROPERTY);
    }


    public void addToMatchedenergytablesCollisionss(MatchedEnergyTablesCollisions obj) {
        addToManyTarget(MATCHEDENERGYTABLES_COLLISIONSS_PROPERTY, obj, true);
    }
    public void removeFromMatchedenergytablesCollisionss(MatchedEnergyTablesCollisions obj) {
        removeToManyTarget(MATCHEDENERGYTABLES_COLLISIONSS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<MatchedEnergyTablesCollisions> getMatchedenergytablesCollisionss() {
        return (List<MatchedEnergyTablesCollisions>)readProperty(MATCHEDENERGYTABLES_COLLISIONSS_PROPERTY);
    }


    public void addToRatecoefficientss(RateCoefficients obj) {
        addToManyTarget(RATECOEFFICIENTSS_PROPERTY, obj, true);
    }
    public void removeFromRatecoefficientss(RateCoefficients obj) {
        removeToManyTarget(RATECOEFFICIENTSS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<RateCoefficients> getRatecoefficientss() {
        return (List<RateCoefficients>)readProperty(RATECOEFFICIENTSS_PROPERTY);
    }


    public void setToCollisions(StatusAvailables toCollisions) {
        setToOneTarget(TO_COLLISIONS_PROPERTY, toCollisions, true);
    }

    public StatusAvailables getToCollisions() {
        return (StatusAvailables)readProperty(TO_COLLISIONS_PROPERTY);
    }


    public void setToContributors(Contributors toContributors) {
        setToOneTarget(TO_CONTRIBUTORS_PROPERTY, toContributors, true);
    }

    public Contributors getToContributors() {
        return (Contributors)readProperty(TO_CONTRIBUTORS_PROPERTY);
    }


    public void setToEnergyCollider(EnergyTables toEnergyCollider) {
        setToOneTarget(TO_ENERGY_COLLIDER_PROPERTY, toEnergyCollider, true);
    }

    public EnergyTables getToEnergyCollider() {
        return (EnergyTables)readProperty(TO_ENERGY_COLLIDER_PROPERTY);
    }


    public void setToEnergyTarget(EnergyTables toEnergyTarget) {
        setToOneTarget(TO_ENERGY_TARGET_PROPERTY, toEnergyTarget, true);
    }

    public EnergyTables getToEnergyTarget() {
        return (EnergyTables)readProperty(TO_ENERGY_TARGET_PROPERTY);
    }


    public void setToRefsGroups(RefsGroups toRefsGroups) {
        setToOneTarget(TO_REFS_GROUPS_PROPERTY, toRefsGroups, true);
    }

    public RefsGroups getToRefsGroups() {
        return (RefsGroups)readProperty(TO_REFS_GROUPS_PROPERTY);
    }


    public void setToRefsMethod(RefsGroups toRefsMethod) {
        setToOneTarget(TO_REFS_METHOD_PROPERTY, toRefsMethod, true);
    }

    public RefsGroups getToRefsMethod() {
        return (RefsGroups)readProperty(TO_REFS_METHOD_PROPERTY);
    }


    public void setToRefsPES(RefsGroups toRefsPES) {
        setToOneTarget(TO_REFS_PES_PROPERTY, toRefsPES, true);
    }

    public RefsGroups getToRefsPES() {
        return (RefsGroups)readProperty(TO_REFS_PES_PROPERTY);
    }


    public void setToRefsReduMass(RefsGroups toRefsReduMass) {
        setToOneTarget(TO_REFS_REDU_MASS_PROPERTY, toRefsReduMass, true);
    }

    public RefsGroups getToRefsReduMass() {
        return (RefsGroups)readProperty(TO_REFS_REDU_MASS_PROPERTY);
    }


    public void setToUnits(Units toUnits) {
        setToOneTarget(TO_UNITS_PROPERTY, toUnits, true);
    }

    public Units getToUnits() {
        return (Units)readProperty(TO_UNITS_PROPERTY);
    }


}
