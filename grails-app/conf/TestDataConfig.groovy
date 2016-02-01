testDataConfig {
    sampleData {
        'fi.lenkkeri.external.equipment.PlaneData' {
			def random = new Random()
			weight = {->1000+random.nextDouble()*99000}
			length = {->1500+random.nextDouble()*99000}
			width = {->1500+random.nextDouble()*99000}
			crewRequired = {->1+random.nextInt(99)}
			seatCount = {->1+random.nextInt(499)}
			fuelCapacity = {->5000+random.nextDouble()*45000}
			nominalRange = {->100+random.nextDouble()*9900}
			maximumRange = {->100+random.nextDouble()*49900}
			//nickname = org.apache.commons.lang.RandomStringUtils.random(9, true, true)
		}
		
    }
}

/*
// sample for creating a single static value for the com.foo.Book's title property:
// title for all Books that we "build()" will be "The Shining", unless explicitly set

testDataConfig {
    sampleData {
        'com.foo.Book' {
            title = "The Shining"
        }
    }
}
*/

/*
// sample for creating a dynamic title for com.foo.Book, useful for unique properties:
// just specify a closure that gets called

testDataConfig {
    sampleData {
        'com.foo.Book' {
            def i = 1
            title = {-> "title${i++}" }   // creates "title1", "title2", ...."titleN"
        }
    }
}
*/

/*
// When using a closure, if your tests expect a particular value, you'll likely want to reset
// the build-test-data config in the setUp of your test, or in the test itself.  Otherwise if
// your tests get run in a different order you'll get different values

// (in test/integration/FooTests.groovy)

void setUp() {
    grails.buildtestdata.TestDataConfigurationHolder.reset()
}
*/


/*
// if you'd like to disable the build-test-data plugin in an environment, just set
// the "enabled" property to false

environments {
    production {
        testDataConfig {
            enabled = false
        }
    }
}
*/