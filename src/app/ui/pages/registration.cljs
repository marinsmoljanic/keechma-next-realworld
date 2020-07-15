(ns app.ui.pages.registration
  (:require [keechma.next.helix.core :refer [with-keechma dispatch call]]
            [keechma.next.helix.lib :refer [defnc]]
            [helix.dom :as d]

            [helix.core :as hx :refer [$ <> suspense]]
            ["react" :as react]
            ["react-dom" :as rdom]
            [app.ui.components.inputs :refer [wrapped-input]]
            [keechma.next.controllers.router :as router]
 ))

;; helix.dom -> gdje se nalazi?
;; sto radi defnc macro?

;; unutar forme on-submit-> kao u reactu? Sprjecavanje slanja podataka na server?
(defnc RegistrationRenderer
  [props]
  (d/div {:class "auth-page"}
    (d/div {:class "container page"}
      (d/div {:class "row"}
        (d/div {:class "col-md-6 offset-md-3 col-xs-12"}
          (d/h1 {:class "text-xs-center"} "Registration form")
          (d/hr)
          (d/p {:class "text-xs-center"} "Already have an account? "
          (d/a {:href (router/get-url props :router {:page "login"})} " Sign in"))
          (d/form
            {:on-submit (fn [e]
                         (.preventDefault e)
                         (dispatch props :registration-form :keechma.form/submit))}
            (wrapped-input {:keechma.form/controller :registration-form
                           :input/type :text
                           :input/attr :username
                           :placeholder "Username"})

            (wrapped-input {:keechma.form/controller :registration-form
                           :input/type :text
                           :input/attr :email
                           :placeholder "Email"})
            (wrapped-input {:keechma.form/controller :registration-form
                           :input/type :text
                           :input/attr [:password]
                           :type "password"
                           :placeholder "Password" })
            (d/button
              {:class "btn btn-lg btn-primary pull-xs-right"} "Register"))))))
)

;; pretpostavljam da je ovo oblik poveznice forme i keechme
(def Registration (with-keechma RegistrationRenderer))