# Why Long At Bats
## An Analysis of the causes (and some effects) of long at-bats

## Introduction

In the sport of baseball, the importance of pitcher fatigue is rapidly being realized. The number of complete games has dwindled significantly as managers become more and more aggressive with bringing in relief pitchers and minimizing unfavorable batting matchups.

By extension, being able to fatigue opposing pitchers creates a perverse incentive to burn through relief pitchers and force managers into the uncomfortable decision of whether to keep pitchers on the mound or to remove them from the game. This project aims to show the root causes of extended pitching matchups in order to better optimize for or against attriting opposing teams.

## Raw Files

Baseball data is publiclly available via [Baseball Savant](https://baseballsavant.mlb.com/). Downloading raw .csv files is as simple as taking an empty query over a subset of days, but these downloads are limited to 25000 entires, so multiple queries are necessary. To save you time, there are 36 raw .csv files already uploaded into this repo. If you want to collect them yourself or explore prior seasons, then follow the link to the Baseball Savant website. Taking data over a five-day span is safe, taking data over a six-day span is risky but the handful that I have done did not exceed the 25000 limit. 

For data from before 2007, you will need to find another source of information, most likely the data taken by people who retroactively watch games to take this type of information. For those who want to collect this kind of data by hand, you are who god fears and I will stay out of your way for my own sake as per the Buster Posey Rule (7.13). 

## Combining Raw Data

The Driver1 File (should - I need to double-check that it works) takes the set of raw .csv files in and outputs a larger .csv file as an output. You will need to manually change the hardcoded values in the Inverter in order to make sure you're grabbing the right data, if you are using data other than what's shown here. 

## Aggregating Large Data

I maually deleted columns from the combined csv. Driver2 assumes that you have already done this. If you have not, you will need to manually update the values the iterator is searching for to actually grab each at-bat. The result will be a 17-column wide (or bigger, if you change what parameters you want) csv file outlining every single at-bat in your timeframe of choice. This is the table that most of the analysis I'm using for this project is coming from, and if you don't want to go through the last few steps, is actually ready-made for you to use without the support of any of the java scripts! You do need those scripts in order to generate any of the intermediary steps, however. 

## R

That aggregated data is being fed into R (4.5 via RStudio) and my plans for the very near future are to create analyses properly tracing the *causes* of long at-bats. What little analysis I have so far entertains the *effects*. 
