#!/bin/bash
# This script initiates the Gradle publishing task when pushes to master occur.
# NOTE: Travis-CI can only publish SNAPSHOT versions. 

if [ "$TRAVIS_REPO_SLUG" == "latency4j/repo" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then
  if [[ $(gradle -q getProjectVersion) != *SNAPSHOT* ]]; then
      echo 'Travis can only publish snapshots.'
  else 
    echo -e "Starting publish to Sonatype...\n"
    gradle uploadArchives -PnexusUsername="${SONATYPE_USERNAME}" -PnexusPassword="${SONATYPE_PASSWORD}"
    RETVAL=$?

    if [ $RETVAL -eq 0 ]; then
      echo 'Completed publish!'
    else
      echo 'Publish failed.'
    fi
  fi
fi
