(ns access-audit-bot.core.clj
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [telegrambot-lib.core :as tbot]))

(def config
  (edn/read-string
   (slurp (io/resource "config.edn"))))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Testing the chatGPT API:")

  (print (api/create-chat-completion {:model "gpt-3.5-turbo"
                                      :messages [{:role "system" :content "You are a helpful assistant."}
                                                 {:role "user" :content "Who won the world series in 2020?"}
                                                 {:role "assistant" :content "The Los Angeles Dodgers won the World Series in 2020."}
                                                 {:role "user" :content "Where was it played?"}]}
                                     {:api-key (:openai-token config)})))
