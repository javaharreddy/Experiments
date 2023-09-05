def is_palindrome(s):
    #hi
    s = s.replace(" ", "").lower()
    return s == s[::-1]