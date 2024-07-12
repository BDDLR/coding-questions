def disappear(grid, row, col):
    if not grid or not grid[0]:
        return 0
    
    N = len(grid)    # Number of rows
    M = len(grid[0]) # Number of columns
    
    # Check if the selected cell is within bounds
    if row < 0 or row >= N or col < 0 or col >= M:
        return 0
    
    # Number at the selected cell
    number = grid[row][col]
    
    # Initialize visited matrix
    visited = [[False] * M for _ in range(N)]
    
    def dfs(r, c):
        # Stack for DFS
        stack = [(r, c)]
        count = 0
        
        while stack:
            x, y = stack.pop()
            
            # If already visited, skip
            if visited[x][y]:
                continue
            
            # Mark as visited
            visited[x][y] = True
            count += 1
            
            # Explore neighbors (up, down, left, right)
            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and grid[nx][ny] == number:
                    stack.append((nx, ny))
        
        return count
    
    # If already visited, return 0
    if visited[row][col]:
        return 0
    
    # Perform DFS from the selected cell
    return dfs(row, col)

# Test cases
grid_1 = [
    [8, 8, 8, 8],
    [1, 1, 1, 8],
    [2, 1, 7, 1]
]

grid_2 = [
    [0, 3, 3, 3, 3, 3, 1],
    [0, 1, 1, 1, 1, 1, 3],
    [0, 2, 2, 0, 2, 1, 4],
    [0, 1, 2, 2, 2, 1, 3],
    [0, 1, 1, 1, 1, 1, 3],
    [0, 0, 0, 0, 0, 0, 0]
]

grid_3 = [[0]]

grid_4 = [
    [1, 1, 1],
    [1, 1, 1],
    [1, 1, 1]
]

grid_5 = [
    [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
]

# Test cases
print(disappear(grid_1, 0, 0))  # Output: 5
print(disappear(grid_1, 1, 1))  # Output: 4
print(disappear(grid_1, 1, 0))  # Output: 4

print(disappear(grid_2, 0, 0))  # Output: 12
print(disappear(grid_2, 3, 0))  # Output: 12
print(disappear(grid_2, 1, 1))  # Output: 13
print(disappear(grid_2, 2, 2))  # Output: 6
print(disappear(grid_2, 0, 3))  # Output: 5

print(disappear(grid_3, 0, 0))  # Output: 1
print(disappear(grid_4, 0, 0))  # Output: 9
print(disappear(grid_5, 0, 11)) # Output: 23
