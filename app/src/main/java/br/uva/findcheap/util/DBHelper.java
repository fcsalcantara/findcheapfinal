package br.uva.findcheap.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String	BANCO_DADOS	= "fincheap";
    private static int VERSAO = 1;

    public DBHelper(Context context)	{
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table usuario (_id integer primary key, nome text, email text, cpf text, senha text);";
        db.execSQL(sql);
        sql = "insert into usuario (nome, email, cpf, senha) values ('admin', 'admin', '000.000.000-00', '12345'), ('fcsa', 'fcsa@', '000.000.000-00', '123456');";
        db.execSQL(sql);
        sql = "create table produto (_id integer primary key, tipo text, marca text, nome text, qtde text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

}
