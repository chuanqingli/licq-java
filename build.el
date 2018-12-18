;; -*- coding: utf-8 -*-
(load-file "../build-basic/build-basic.el")


;; (defun get-jar-files()
;; (setq jarpath '("WebRoot/WEB-INF/lib"));;"D:/javalib" "../repository/lib"
;; ;; (setq jarpath '("/media/win/D/chuanqing/workspace/lib"));;"D:/javalib"
;; (setq jarfiles '())

;; ;; (setq jarfiles (append jarfiles "WebRoot/WEB-INF/lib/tianya-fw-1.7.20.jar"))
;; (dolist (path jarpath)
;;   (dolist (file (get-jar-files-list)) (setq jarfiles (append jarfiles (list (format "%s/%s.jar" path (symbol-name file))))))
;; ;; (dolist (file (directory-files (concat path ".") nil ".jar$" 'nosort)) (setq jarfiles (append jarfiles (list (format "%s/%s" path file)))))
;;   )
;; jarfiles
;;   )


(defun get-jar-files-list()
  '(
jsdk-24

    slf4j-api-1.6.4
slf4j-log4j12-1.6.4

log4j-1.2.15
jackson-core-asl-1.9.13
jackson-mapper-asl-1.9.13


json-lib-2.4-jdk15
commons-lang-2.5

junit
;; junit-4.13-beta-1
;; hamcrest-core-2.1-rc3
;; fastjson-1.2.4
;; xom-1.2.10
;; xwork-core-2.2.1

    )
  )



(do-main argv)
(provide 'build)
