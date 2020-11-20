
# There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

# Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

# Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

# Example 1:

# Input: numCourses = 2, prerequisites = [[1,0]]
# Output: true
# Explanation: There are a total of 2 courses to take. 
#              To take course 1 you should have finished course 0. So it is possible.
# Example 2:

# Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
# Output: false
# Explanation: There are a total of 2 courses to take. 
#              To take course 1 you should have finished course 0, and to take course 0 you should
#              also have finished course 1. So it is impossible.

# https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2983/

from collections import defaultdict
from typing import List
class Solution:
    def canFinish_backtracking(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseDict = defaultdict(list)

        for relation in prerequisites:
            nextCourse, prevCourse = relation[0], relation[1]
            courseDict[prevCourse].append(nextCourse)

            path = [False] * numCourses

        for currentCourse in range(numCourses):
            if self.isCyclic(currentCourse, courseDict, path):
                return False
        
        return True

    def isCyclic(self, currentCourse, courseDict, path):

        if path[currentCourse]:
            # find a cycle, flag is True
            return True

        else:
            path[currentCourse] = True

            result =  False
            for child in courseDict[currentCourse]:
                result = self.isCyclic(child, courseDict, path)
                if result:
                    break
            
            path[currentCourse] = False

            return result