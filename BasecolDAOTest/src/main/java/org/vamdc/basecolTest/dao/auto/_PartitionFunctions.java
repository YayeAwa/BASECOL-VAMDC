package org.vamdc.basecolTest.dao.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.vamdc.BasecolTest.dao.Elements;
import org.vamdc.BasecolTest.dao.PartitionFunctionsValues;
import org.vamdc.BasecolTest.dao.RefsGroups;
import org.vamdc.BasecolTest.dao.Symmetries;

/**
 * Class _PartitionFunctions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PartitionFunctions extends CayenneDataObject {

    public static final String ID_PARTITION_PROPERTY = "idPartition";
    public static final String PARTITIONFUNCTIONS_VALUESES_PROPERTY = "partitionfunctionsValueses";
    public static final String TO_ELEMENTS_PROPERTY = "toElements";
    public static final String TO_REFS_GROUPS_PROPERTY = "toRefsGroups";
    public static final String TO_SYMMETRIES_PROPERTY = "toSymmetries";

    public static final String ID_PARTITION_PK_COLUMN = "idPartition";

    public void setIdPartition(Long idPartition) {
        writeProperty(ID_PARTITION_PROPERTY, idPartition);
    }
    public Long getIdPartition() {
        return (Long)readProperty(ID_PARTITION_PROPERTY);
    }

    public void addToPartitionfunctionsValueses(PartitionFunctionsValues obj) {
        addToManyTarget(PARTITIONFUNCTIONS_VALUESES_PROPERTY, obj, true);
    }
    public void removeFromPartitionfunctionsValueses(PartitionFunctionsValues obj) {
        removeToManyTarget(PARTITIONFUNCTIONS_VALUESES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PartitionFunctionsValues> getPartitionfunctionsValueses() {
        return (List<PartitionFunctionsValues>)readProperty(PARTITIONFUNCTIONS_VALUESES_PROPERTY);
    }


    public void setToElements(Elements toElements) {
        setToOneTarget(TO_ELEMENTS_PROPERTY, toElements, true);
    }

    public Elements getToElements() {
        return (Elements)readProperty(TO_ELEMENTS_PROPERTY);
    }


    public void setToRefsGroups(RefsGroups toRefsGroups) {
        setToOneTarget(TO_REFS_GROUPS_PROPERTY, toRefsGroups, true);
    }

    public RefsGroups getToRefsGroups() {
        return (RefsGroups)readProperty(TO_REFS_GROUPS_PROPERTY);
    }


    public void setToSymmetries(Symmetries toSymmetries) {
        setToOneTarget(TO_SYMMETRIES_PROPERTY, toSymmetries, true);
    }

    public Symmetries getToSymmetries() {
        return (Symmetries)readProperty(TO_SYMMETRIES_PROPERTY);
    }


}
