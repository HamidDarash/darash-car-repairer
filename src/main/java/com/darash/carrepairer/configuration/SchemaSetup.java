package com.darash.carrepairer.configuration;

public class SchemaSetup extends RunCQLFile {
    //    private static final String cqlFile = "cql/math.cql";
    private String cqlFile;

    public SchemaSetup(String cqlFile) {
        super(cqlFile);
        this.cqlFile = cqlFile;
    }

    public void runCQL() {
        SchemaSetup setup = new SchemaSetup(this.cqlFile);
        setup.internalSetup();
        setup.shutdown();
    }
}
