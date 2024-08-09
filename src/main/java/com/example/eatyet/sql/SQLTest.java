package com.example.eatyet.sql;

public class SQLTest {
    public static final String test =
            "SELECT\n" +
                    "\tr.id as id,\n" +
                    "\tr.created_by as created_by,\n" +
                    "\tr.created_on as created_on,\n" +
                    "\tr.evaluation_point as evaluation_point,\n" +
                    "\tp.`review` as `name`\n" +
                    "FROM\n" +
                    "\trate r\n" +
                    "\tINNER JOIN\n" +
                    "\tpost_comment p\n" +
                    "\tON \n" +
                    "\t\tp.id = 1";
}
