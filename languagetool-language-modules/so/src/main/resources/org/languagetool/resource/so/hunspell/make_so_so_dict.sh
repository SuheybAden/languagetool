#!/bin/sh

unmunch so_SO.dic so_SO.aff > so_SO1.txt
cat so_SO1.txt | java -cp /home/suheyb/code/languagetool/languagetool-standalone/target/LanguageTool-6.3-SNAPSHOT/LanguageTool-6.3-SNAPSHOT/languagetool.jar:/home/suheyb/code/languagetool/languagetool-dev/target/languagetool-dev-6.3-SNAPSHOT.jar org.languagetool.dev.archive.WordTokenizer so | sort -u > so_SO.txt
java -cp /home/suheyb/code/languagetool/languagetool-standalone/target/LanguageTool-6.3-SNAPSHOT/LanguageTool-6.3-SNAPSHOT/languagetool.jar org.languagetool.tools.SpellDictionaryBuilder -i so_SO1.txt -o so_SO.dict -info so_SO.info