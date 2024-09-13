import React from 'react'
import Premio from './premio'
import GenerateBoard from './generateboard'
import { Card, CardHeader, CardContent } from '@mui/material'

function Board() {
    return (
        <Card>
            <CardHeader>
                <Premio></Premio>
            </CardHeader>
            <CardContent>
                <GenerateBoard></GenerateBoard>
            </CardContent>
        </Card>

    )
}

export default Board