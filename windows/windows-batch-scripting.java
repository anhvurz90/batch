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
3.Return Codes: {
  3.1.Return Code Conventions: {
    - return 0: execution succeeds
    - return non-zero: execution fails
  }
  3.2.Checking Return Codes in your script Commands: {
    - %ERRORLEVEL%: contains the return code of the LAST executed program or script.
  }
  3.3.Conditional Execution Using the Return Code: {
    - To execute a follow-on command after sucess, we use the && operator:
      + SomeCommand.exe && ECHO SomeCommand.ext succeeded!
    - To execute a follow-on command after failure, we use the || operator:
      + SomeCommand.exe || ECHO SomeCommand.exe failed with return code %ERRORLEVEL%:
        * SomeCommand.exe || EXIT /B 1
        * SomeCommand.exe || GOTO :EOF
  }
  3.4.Tips and Tricks for Return Codes: {
    SET /A ERROR_HELP_SCREEN=1
    SET /A ERROR_FILE_NOT_FOUND=2
  }
  3.5.Some Final Polish
}
4.Stdin, Stdout, Stderr: {
  4.1.File Numbers: {
    - Stdin: 0, stdout: 1, stderr: 2
  }
  4.2.Redirection: {
    - DIR > temp.txt: override
    - DIR >> temp.txt: append
    - DIR SomeFile.txt 2>> error.txt: redirect stderr
    - DIR SomeFile.txt 2>&1: write both stdout & stderr to a single log file
    - SORT < SomeFile.txt: from stdin
  }
  4.3.Suppressing Program Output: {
    - Use the psedofile NUL:
      PING 127.0.0.1 > NUL
  }
  4.4.Redirecting Program Output As Input to Another Program: {
    - DIR /B | SORT
  }
  4.5.A Coll Party Trick: {
    - Quick way to create a new text file:
      TYPE CON > output.txt
        Hello
        World!
      ^Z
  }
}
