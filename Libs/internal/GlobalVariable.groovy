package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_userName
     
    /**
     * <p></p>
     */
    public static Object G_Password
     
    /**
     * <p></p>
     */
    public static Object G_JobID
     
    /**
     * <p></p>
     */
    public static Object G_Browser
     
    /**
     * <p></p>
     */
    public static Object G_BaseUrl
     
    /**
     * <p></p>
     */
    public static Object G_ReportName
     
    /**
     * <p></p>
     */
    public static Object G_JobIdFromDetails
     
    /**
     * <p></p>
     */
    public static Object G_BrowserVersion
     
    /**
     * <p></p>
     */
    public static Object G_DownloadFolder
     
    /**
     * <p></p>
     */
    public static Object G_ReportFolder
     
    /**
     * <p></p>
     */
    public static Object G_ConfigFile
     
    /**
     * <p></p>
     */
    public static Object G_TestSuite
     
    /**
     * <p></p>
     */
    public static Object G_HostMachine
     
    /**
     * <p></p>
     */
    public static Object G_Platform
     
    /**
     * <p></p>
     */
    public static Object G_PBSHostName
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            G_userName = selectedVariables['G_userName']
            G_Password = selectedVariables['G_Password']
            G_JobID = selectedVariables['G_JobID']
            G_Browser = selectedVariables['G_Browser']
            G_BaseUrl = selectedVariables['G_BaseUrl']
            G_ReportName = selectedVariables['G_ReportName']
            G_JobIdFromDetails = selectedVariables['G_JobIdFromDetails']
            G_BrowserVersion = selectedVariables['G_BrowserVersion']
            G_DownloadFolder = selectedVariables['G_DownloadFolder']
            G_ReportFolder = selectedVariables['G_ReportFolder']
            G_ConfigFile = selectedVariables['G_ConfigFile']
            G_TestSuite = selectedVariables['G_TestSuite']
            G_HostMachine = selectedVariables['G_HostMachine']
            G_Platform = selectedVariables['G_Platform']
            G_PBSHostName = selectedVariables['G_PBSHostName']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}