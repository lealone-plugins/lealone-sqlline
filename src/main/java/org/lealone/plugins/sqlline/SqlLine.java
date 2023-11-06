/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package org.lealone.plugins.sqlline;

import java.io.IOException;

import org.lealone.db.ConnectionInfo;
import org.lealone.main.Lealone;

public class SqlLine extends sqlline.SqlLine {

    public static void main(String[] args) throws IOException {
        for (int i = 0; args != null && i < args.length; i++) {
            String arg = args[i];
            arg = arg.trim();
            if (arg.isEmpty())
                continue;
            if (arg.equals("-u")) {
                String url = args[++i];
                java.util.Properties info = new java.util.Properties();
                ConnectionInfo ci = new ConnectionInfo(url, info);
                if (ci.isEmbedded()) {
                    Lealone.embed();
                }
            }
        }
        sqlline.SqlLine.main(args);
    }
}
