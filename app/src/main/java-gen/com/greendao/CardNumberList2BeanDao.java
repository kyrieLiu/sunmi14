package com.greendao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import ys.app.pad.itemmodel.CardNumberList2Bean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CARD_NUMBER_LIST2_BEAN".
*/
public class CardNumberList2BeanDao extends AbstractDao<CardNumberList2Bean, Long> {

    public static final String TABLENAME = "CARD_NUMBER_LIST2_BEAN";

    /**
     * Properties of entity CardNumberList2Bean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CardId = new Property(0, int.class, "cardId", false, "CARD_ID");
        public final static Property Id = new Property(1, long.class, "id", true, "_id");
        public final static Property Number = new Property(2, int.class, "number", false, "NUMBER");
        public final static Property ProductId = new Property(3, int.class, "productId", false, "PRODUCT_ID");
        public final static Property ProductName = new Property(4, String.class, "productName", false, "PRODUCT_NAME");
        public final static Property RealAmt = new Property(5, double.class, "realAmt", false, "REAL_AMT");
        public final static Property Type = new Property(6, int.class, "type", false, "TYPE");
        public final static Property NumCardId = new Property(7, Long.class, "numCardId", false, "NUM_CARD_ID");
    }

    private Query<CardNumberList2Bean> numCardListInfo_CardNumberList2Query;

    public CardNumberList2BeanDao(DaoConfig config) {
        super(config);
    }
    
    public CardNumberList2BeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CARD_NUMBER_LIST2_BEAN\" (" + //
                "\"CARD_ID\" INTEGER NOT NULL ," + // 0: cardId
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 1: id
                "\"NUMBER\" INTEGER NOT NULL ," + // 2: number
                "\"PRODUCT_ID\" INTEGER NOT NULL ," + // 3: productId
                "\"PRODUCT_NAME\" TEXT," + // 4: productName
                "\"REAL_AMT\" REAL NOT NULL ," + // 5: realAmt
                "\"TYPE\" INTEGER NOT NULL ," + // 6: type
                "\"NUM_CARD_ID\" INTEGER);"); // 7: numCardId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CARD_NUMBER_LIST2_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CardNumberList2Bean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCardId());
        stmt.bindLong(2, entity.getId());
        stmt.bindLong(3, entity.getNumber());
        stmt.bindLong(4, entity.getProductId());
 
        String productName = entity.getProductName();
        if (productName != null) {
            stmt.bindString(5, productName);
        }
        stmt.bindDouble(6, entity.getRealAmt());
        stmt.bindLong(7, entity.getType());
 
        Long numCardId = entity.getNumCardId();
        if (numCardId != null) {
            stmt.bindLong(8, numCardId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CardNumberList2Bean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCardId());
        stmt.bindLong(2, entity.getId());
        stmt.bindLong(3, entity.getNumber());
        stmt.bindLong(4, entity.getProductId());
 
        String productName = entity.getProductName();
        if (productName != null) {
            stmt.bindString(5, productName);
        }
        stmt.bindDouble(6, entity.getRealAmt());
        stmt.bindLong(7, entity.getType());
 
        Long numCardId = entity.getNumCardId();
        if (numCardId != null) {
            stmt.bindLong(8, numCardId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 1);
    }    

    @Override
    public CardNumberList2Bean readEntity(Cursor cursor, int offset) {
        CardNumberList2Bean entity = new CardNumberList2Bean( //
            cursor.getInt(offset + 0), // cardId
            cursor.getLong(offset + 1), // id
            cursor.getInt(offset + 2), // number
            cursor.getInt(offset + 3), // productId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // productName
            cursor.getDouble(offset + 5), // realAmt
            cursor.getInt(offset + 6), // type
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7) // numCardId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CardNumberList2Bean entity, int offset) {
        entity.setCardId(cursor.getInt(offset + 0));
        entity.setId(cursor.getLong(offset + 1));
        entity.setNumber(cursor.getInt(offset + 2));
        entity.setProductId(cursor.getInt(offset + 3));
        entity.setProductName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRealAmt(cursor.getDouble(offset + 5));
        entity.setType(cursor.getInt(offset + 6));
        entity.setNumCardId(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CardNumberList2Bean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CardNumberList2Bean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CardNumberList2Bean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "cardNumberList2" to-many relationship of NumCardListInfo. */
    public List<CardNumberList2Bean> _queryNumCardListInfo_CardNumberList2(Long numCardId) {
        synchronized (this) {
            if (numCardListInfo_CardNumberList2Query == null) {
                QueryBuilder<CardNumberList2Bean> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.NumCardId.eq(null));
                numCardListInfo_CardNumberList2Query = queryBuilder.build();
            }
        }
        Query<CardNumberList2Bean> query = numCardListInfo_CardNumberList2Query.forCurrentThread();
        query.setParameter(0, numCardId);
        return query.list();
    }

}
