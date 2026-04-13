class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Get number of rows and columns in the matrix
        ROWS, COLS = len(matrix), len(matrix[0])

        # Treat the 2D matrix as a flattened 1D array of size ROWS*COLS
        l, r = 0, ROWS * COLS - 1

        # Perform standard binary search on this virtual 1D array
        while l <= r:
            # Middle index in the virtual 1D array
            m = l + (r - l) // 2

            # Convert the 1D index back to 2D (row, col) position
            row, col = m // COLS, m % COLS

            # Compare the target with the middle element
            if target > matrix[row][col]:
                # If target is greater, discard the left half
                l = m + 1
            elif target < matrix[row][col]:
                # If target is smaller, discard the right half
                r = m - 1
            else:
                # Found the target
                return True

        # If loop ends, target is not in the matrix
        return False
