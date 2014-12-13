(ns migae.user-test
  (:import [com.google.appengine.tools.development.testing
            LocalServiceTestHelper
            LocalServiceTestConfig
            LocalMemcacheServiceTestConfig])
  (:require [clojure.test :refer :all]
            [migae.user :as u]
            [clojure.tools.logging :as log :only [trace debug info]]))


private final LocalServiceTestHelper helper =
new LocalServiceTestHelper(new LocalUserServiceTestConfig())
.setEnvIsAdmin(true).setEnvIsLoggedIn(true);

@Before
public void setUp() {
                     helper.setUp();
                     }

@After
public void tearDown() {
                        helper.tearDown();
                        }

@Test
public void testIsAdmin() {
                           UserService userService = UserServiceFactory.getUserService();
                           assertTrue(userService.isUserAdmin());
                           }
