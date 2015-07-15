import org.openqa.selenium.htmlunit.HtmlUnitDriver

import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.Dimension

driver = {
	new HtmlUnitDriver()
}

reportsDir = "build/geb-reports"

environments {
	// run as "grails -Dgeb.env=phantomjs test-app
	phantomjs {
		driver = {
		    def driver = new PhantomJSDriver(new DesiredCapabilities())
		    driver.manage().window().setSize(new Dimension(1028, 100))
		    driver		
		}
	}
}
