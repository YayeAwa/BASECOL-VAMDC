package org.vamdc.basecolTest.dao.auto;

import org.apache.cayenne.CayenneDataObject;
import org.vamdc.BasecolTest.dao.Collisions;
import org.vamdc.BasecolTest.dao.ForeignValuesSets;

/**
 * Class _ForeignValuesSetsCollisions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ForeignValuesSetsCollisions extends CayenneDataObject {

    public static final String ID_COLLISION_PROPERTY = "idCollision";
    public static final String ID_FOREIGN_VALUES_SET_PROPERTY = "idForeignValuesSet";
    public static final String TO_COLLISIONS_PROPERTY = "toCollisions";
    public static final String TO_FOREIGN_VALUES_SETS_PROPERTY = "toForeignValuesSets";

    public static final String ID_COLLISION_PK_COLUMN = "idCollision";
    public static final String ID_FOREIGN_VALUES_SET_PK_COLUMN = "idForeignValuesSet";

    public void setIdCollision(Long idCollision) {
        writeProperty(ID_COLLISION_PROPERTY, idCollision);
    }
    public Long getIdCollision() {
        return (Long)readProperty(ID_COLLISION_PROPERTY);
    }

    public void setIdForeignValuesSet(Short idForeignValuesSet) {
        writeProperty(ID_FOREIGN_VALUES_SET_PROPERTY, idForeignValuesSet);
    }
    public Short getIdForeignValuesSet() {
        return (Short)readProperty(ID_FOREIGN_VALUES_SET_PROPERTY);
    }

    public void setToCollisions(Collisions toCollisions) {
        setToOneTarget(TO_COLLISIONS_PROPERTY, toCollisions, true);
    }

    public Collisions getToCollisions() {
        return (Collisions)readProperty(TO_COLLISIONS_PROPERTY);
    }


    public void setToForeignValuesSets(ForeignValuesSets toForeignValuesSets) {
        setToOneTarget(TO_FOREIGN_VALUES_SETS_PROPERTY, toForeignValuesSets, true);
    }

    public ForeignValuesSets getToForeignValuesSets() {
        return (ForeignValuesSets)readProperty(TO_FOREIGN_VALUES_SETS_PROPERTY);
    }


}