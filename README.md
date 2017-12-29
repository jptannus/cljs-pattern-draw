# ClojureScript - Pattern Draw
[![Waffle.io - Columns and their card count](https://badge.waffle.io/jptannus/cljs-pattern-draw.svg?columns=all)](https://waffle.io/jptannus/cljs-pattern-draw) 

[![CircleCI](https://circleci.com/gh/jptannus/cljs-pattern-draw/tree/master.svg?style=svg)](https://circleci.com/gh/jptannus/cljs-pattern-draw/tree/master)

A tool to draw some patterns in the browser.

## Overview

A tool to draw some patterns in the browser

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.
