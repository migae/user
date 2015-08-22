(ns migae.user
  (:import [com.google.appengine.api.users
            User
            UserService
            UserServiceFactory]))

;; derived from appengine-magic

(defonce ^{:dynamic true} *user-service* (atom nil))


(defn get-user-service []
  (when (nil? @*user-service*)
    (reset! *user-service* (UserServiceFactory/getUserService)))
  @*user-service*)


(defn current-user []
  (.getCurrentUser (get-user-service)))


(defn user-logged-in? []
  (.isUserLoggedIn (get-user-service)))


(defn user-admin? []
  (.isUserAdmin (get-user-service)))


(defn login-url [& {:keys [destination]
                    :or {destination "/"}}]
  (.createLoginURL (get-user-service) destination))

(defn login-federated [& {:keys [destination fedIdentity]
                          :or {destination "/"}}]
  (.createLoginURL (get-user-service) destination
                   nil fedIdentity nil))


(defn logout-url [& {:keys [destination]
                     :or {destination "/"}}]
  (.createLogoutURL (get-user-service) destination))


;; User api
(defn compare-to [#^User user]
  (.compareTo user))

(defn equals [#^User user ^Object obj]
  (.equals user obj))

(defn get-auth-domain [#^User user]
  (.getAuthDomain user))

(defn get-email [#^User user]
  (.getEmail user))

(defn get-federated-identity [#^User user]
  (.getFederatedIdentity user))

(defn get-nickname [#^User user]
  (.getNickname user))

(defn get-id [#^User user]
  (.getUserId user))

(defn hash-code [#^User user]
  (.hashCode user))

(defn to-string [#^User user]
  (.toString user))

