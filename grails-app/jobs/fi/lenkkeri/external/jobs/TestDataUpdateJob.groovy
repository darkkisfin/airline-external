package fi.lenkkeri.external.jobs



class TestDataUpdateJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        // execute job
    }
}
