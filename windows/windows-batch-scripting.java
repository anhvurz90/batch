	WINDOWS BATCH SCRIPTING:
Link: http://steve-jansen.github.io/guides/windows-batch-scripting/part-1-getting-started.html
0.Overview
1.Getting Started: {
  1.1.Getting Started with Windows Batch Scripting:
  1.2.Launching the Command Prompt: {
    - Windows + R > cmd
  }
  1.3.Editting Batch Files
  1.4.Viewing Batch Files: {
    - Nodepad
    - Type myscript.cmd
    - More myscript.cmd
    - Edit myscript.cmd
  }
  1.5.Batch File Names and File Extensions {
    - .cmd is better than .bat (due to some rare side effects with .bat files)
  }
  1.6.Saving Batch Files in Windows
  1.7.Running your Batch File:
  1.8.Comments: {
    REM This is a comment!
    :: This is a comment, too!!
  }
  1.9.Silencing Display of Commands in Batch Files: {
    - @ECHO OFF
    - ECHO ON
  }
  1.10.Debugging Your Scripts: {
    - No way, just print debugging messages via ECHO command.
  }
}
2.Variables: {
  2.1.Variable Declaration: Not required
  2.2.Variable Assignment: {
    - SET foo=bar -> OK
    SET foo = bar -> KO, no whitespace here
    - SET /A four=2+2 (/A:arithmetic)
  }
  2.3.Reading the Value of a Variable: {
    ECHO %foo%
  }
  2.4.Listing Existing Variables: {
    - SET command without argument
  }
  2.5.Variable Scope (Global vs Local): {
    - SETLOCAL
    - ENDLOCAL
  }
  2.6.Special Variables:
  2.7.Command Line Arguments to Your Script: {
    - %0: the script file name
    - %1: the first argument
      ...
    - %9: the ninth argument
  }
  2.8.Tricks with Command Line Arguments: {
    - %~1: removes quotes from the 1st command line argument(useful for file path)
    - %~f1: full path to the folder of the first command line argument
    - %~fs1: DOS8.3 short name path of %~f1
    - %~dp1: full path to the parent folder of the 1st command line argument
    - %~nx1: file name and file extension of the 1st command line argument
  }
  2.9.Some Final Polish: {
    - SETLOCAL ENABLEEXTENSIONS
    - SET me=%~n0
    - SET parent=%~dp0
  }
}
