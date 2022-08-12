package com.testcases;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;




@RunWith(JUnitPlatform.class)
@SelectPackages({"com.testcases"})
//@IncludePackages({"com.testcases.trial"})
@ExcludePackages({"com.testcases.trial"})
class AllTests {

}
