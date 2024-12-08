package context;

import com.google.gson.JsonObject;
import com.microsoft.playwright.*;

public class commonconfigs {

    private Page page;
    private String cdpUrl;
    private Browser browser;
    private BrowserContext context;
    private Playwright playwright;
    private BrowserType browserType;
    private final String username = "kdhand2";
    private final String accessKey = "CtSOjmjSWEH8nb5P1izMThNjbHdGVC2fcoZ2Is3HtKDlxAieCK";

    public commonconfigs() {
    }

    public void openBrowser() {
        playwright = Playwright.create();
        lamdaSetup();
        String browserTypeString = System.getProperty("BrowserType");
        System.out.println("BrowserType: " + browserTypeString);
        boolean headless = Boolean.parseBoolean(System.getProperty("headLess"));
        browserType = getBrowserType(browserTypeString);
        browser = browserType.connect(cdpUrl);
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920, 1080);
    }

    private BrowserType getBrowserType(String browserTypeString) {
        return switch (browserTypeString.toLowerCase()) {
            case "chrome" -> playwright.chromium();
            case "webkit" -> playwright.webkit();
            case "firefox" -> playwright.firefox();
            default -> throw new IllegalArgumentException("Browser not supported: " + browserTypeString);
        };
    }

    public Page getPage() {
        return page;
    }

    private void lamdaSetup() {
        JsonObject capabilities = new JsonObject();
        JsonObject ltOptions = new JsonObject();

        capabilities.addProperty("browserName", "Chrome"); // Browsers allowed: `Chrome`, `MicrosoftEdge`, `pw-chromium`, `pw-firefox` and `pw-webkit`
        capabilities.addProperty("browserVersion", "latest");
        ltOptions.addProperty("platform", "Windows 11");
        ltOptions.addProperty("name", "Playwright Test");
        ltOptions.addProperty("build", "Playwright Java Build");
        ltOptions.addProperty("user", username);
        ltOptions.addProperty("accessKey", accessKey);
        capabilities.add("LT:Options", ltOptions);

        cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + capabilities;
    }

    public void teardown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}