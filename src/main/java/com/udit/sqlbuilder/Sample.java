package com.udit.sqlbuilder;

import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.ComboCondition;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

public class Sample {

    private static final String SALES_QUANTITY = "sales_units";
    private static final String SALES_VALUE = "sales_retail";
    private static final String DATE = "week_start_date";

    private static final String PRODUCT_UUID = "product_uuid";
    private static final String ATTRIBUTE_ID = "attribute_id";
    private static final String ATTRIBUTE_VALUE = "attribute_value";

    private static final String LEVEL_ID = "level_id";
    private static final String LEVEL_VALUE = "level_value";


    public static void main(String[] args) {
        SelectQuery selectQuery = new SelectQuery();
        DbSpec spec = new DbSpec();
        DbSchema schema = spec.addDefaultSchema();
        DbTable salesInsightsTable = schema.addTable("sales_insight_view");

        DbTable attributeTable = schema.addTable("PLANNING_PRODUCT_ATTRIBUTE");

        DbTable levelTable = schema.addTable("PLANNING_PRODUCT_LEVEL");

        DbColumn attributeProductId = attributeTable.addColumn(PRODUCT_UUID);
        DbColumn attributeId = attributeTable.addColumn(ATTRIBUTE_ID);
        DbColumn productId = attributeTable.addColumn(PRODUCT_UUID);

        DbColumn levelProductId = levelTable.addColumn(PRODUCT_UUID);
        DbColumn levelId = levelTable.addColumn(LEVEL_ID);
        DbColumn levelValue = levelTable.addColumn(LEVEL_VALUE);

        DbColumn dateColumn = salesInsightsTable.addColumn(DATE);
        DbColumn salesQty = salesInsightsTable.addColumn(SALES_QUANTITY);
        DbColumn salesValue = salesInsightsTable.addColumn(SALES_VALUE);
        DbColumn salesProductId = salesInsightsTable.addColumn(PRODUCT_UUID);

        BinaryCondition productIdEqual = BinaryCondition.equalTo(attributeProductId, levelProductId);
        BinaryCondition sample = BinaryCondition.equalTo(attributeId, "sample");
        ComboCondition comboCondition = ComboCondition.and(sample, productIdEqual);

        String s = selectQuery.addAllColumns()
                .addJoin(
                        SelectQuery.JoinType.INNER,
                        attributeTable,
                        levelTable, comboCondition
                ).addJoin(SelectQuery.JoinType.INNER, attributeTable, salesInsightsTable,
                        BinaryCondition.equalTo(attributeProductId, salesProductId)).toString();


        System.out.println("s = " + s);
    }

}
