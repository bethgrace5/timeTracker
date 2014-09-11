package com.bethgrace5.timetracker;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class LoginActionTestCase extends StrutsTestCase {
    private LoginAction action;
    private Map<String, Object> session;

    public void setUp() throws Exception {
        // any initialization logic goes here
        //
        // for example, if we need some dummy objects in the database to verify
        // our assumptions for this test, this is where you do it

        // this is required
        super.setUp();
    }

    private void init(String url) {
        ActionProxy proxy = getActionProxy(url);
        proxy.setExecuteResult(false);
        this.action = (LoginAction) proxy.getAction();

        this.session = new HashMap<String, Object>();
        this.action.setSession(session);
    }

    public void testGoodLogin() throws Exception {
        this.init("/login");

        // verify that to start, we are not logged in, which we can tell when
        // the session doesn't have a userId stored in it
        assertNull("User should not be logged in", session.get("userId"));

        // FIXME -- add requirement for password when we support passwords
        this.action.setUserName("bethgrace5");
        this.action.setPassword("doesntmatter");
        String response = this.action.login();

        // verify that we received a "success" response from the action, if the
        // user exists on GitHub
        assertEquals("Login response should be 'success'", "success", response);

        // verify that the session now stores a userId, proving we are logged
        // in
        assertNotNull("User should be logged in", session.get("userId")) ;
    }

    public void tearDown() throws Exception {
        // any destruction logic goes here
        //
        // for example, if we created objects in this test and want to destroy
        // them so we don't contaminate the database, this is where you do it

        // this is required
        super.tearDown();
    }
}
